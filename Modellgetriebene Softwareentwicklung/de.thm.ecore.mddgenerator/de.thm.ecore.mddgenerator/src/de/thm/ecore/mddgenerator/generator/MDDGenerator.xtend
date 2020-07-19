package de.thm.ecore.mddgenerator.generator

import java.io.ByteArrayInputStream
import java.io.InputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.resource.Resource
import de.thm.ecore.mddgenerator.util.ImportStatementFinder
import de.thm.ecore.mddgenerator.util.JavaFormatter
import de.thm.ecore.mddgenerator.util.XmlFormatter
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EcorePackage
import Metamodel.PersistenceConfig

/**
 * The generator for ecore files.
 * 
 * @author Marco Richter
 */
class MDDGenerator {
	
	/**
	 * The path where to generate the Java files.
	 */
	public static final String SOURCE_FOLDER_PATH = "src-gen/";
	
	/**
	 * The base package name.
	 */
	public static final String PACKAGE = "de.thm.mdd.testapp.";
	
	public static final String PACKAGE_PATH = "/" + PACKAGE.replaceAll("\\.", "/");
	
	public static final String COMPLETE_PATH = SOURCE_FOLDER_PATH + PACKAGE_PATH;
	
	// Ecore
	public static final String EXTENDED_META_DATA = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
	public static final String MAX_INCLUSIVE = "maxInclusive";
	public static final String MIN_INCLUSIVE = "minInclusive";
	
	var ImportStatementFinder importFinder = new ImportStatementFinder()
	
	Resource metaModelResource;
	
	/**
	 * Creates a file (containing the content-CharSequence) within the given IFolder.
	 */
	def void createFile(IFolder folder, String fileName, boolean overrideFile, CharSequence content, IProgressMonitor progressMonitor) {
		if (progressMonitor.canceled) {
			throw new RuntimeException("Progress canceled");
		}
		if (!folder.exists()) {
			folder.create(true, true, null);
   		}
   		var IFile iFile = folder.getFile(fileName);
   		//TODO, nur in der Testphase
		if (iFile.exists &&  true/*overrideFile*/) {
			iFile.delete(true, null);
		}	
		if (!iFile.exists) {
			// process the code
			var String formattedCode
			if (fileName.endsWith(".java")) {
				// organize imports
				var String sourceWithImports = importFinder.getWithImports(content.toString);
				// format the code
				formattedCode = JavaFormatter.format(sourceWithImports);
			} else if (fileName.endsWith(".xml")) {
				// format the code
				formattedCode = XmlFormatter.format(content.toString)
			}
			
	    	var byte[] bytes
	    	if (formattedCode !== null) { // has the code been formatted?
	    		bytes = formattedCode.getBytes();
	    	} else { // code could not be formatted
	    		bytes = content.toString.bytes;
	    		System.err.println("File " + fileName + " could not be formatted.")
	    	}
	    	// save the file
	    	var InputStream source = new ByteArrayInputStream(bytes);
			iFile.create(source, true, null);		
		}
	}
	
	/**
	 * Starts the generation of the given Resource file in the given IProject.
	 */
	def void doGenerate(Resource resourceEcore, Resource resourceMetamodel, IProject project, IProgressMonitor progressMonitor) {
		try {
			this.metaModelResource = resourceMetamodel;
			
			// begin the task with the amount of work
			progressMonitor.beginTask("Generating Java code", 2);
			
			progressMonitor.subTask("Creating folders");
			
			// create deeper folders
			var IFolder folder =  project.getFolder(SOURCE_FOLDER_PATH + "de");
			if (!folder.exists()) {
	   			folder.create(true, true, null);
	   		}
	   		folder = project.getFolder(SOURCE_FOLDER_PATH + "/de/thm");
	   		if (!folder.exists()) {
	   			folder.create(true, true, null);
			}
			folder = project.getFolder(SOURCE_FOLDER_PATH + "/de/thm/mdd");
	   		if (!folder.exists()) {
	   			folder.create(true, true, null);
			}
	   		folder = project.getFolder(SOURCE_FOLDER_PATH + "/de/thm/mdd/testapp");
	   		if (!folder.exists()) {
	   			folder.create(true, true, null);	
	   		}
	   		// create entity package folder
	   		folder = project.getFolder(SOURCE_FOLDER_PATH + PACKAGE_PATH + "entities");
	   		if (!folder.exists()) {
	   			folder.create(true, true, null);
	   		}  
	   		makeProgressAndCheckCanceled(progressMonitor);
	   		
	   		/*
	   		 * We start to generate the classes for our application. First we create the *Gen classes, then die classes which extends the *Gen classes, in which the
	   		 * user can to customizations.
	   		 */ 			 
			
			// create Entities
			var IFolder entityFolder = project.getFolder(SOURCE_FOLDER_PATH + PACKAGE_PATH + "entities");
			progressMonitor.subTask("Generating Entities");
			for (EClass e : resourceEcore.allContents.toIterable.filter(typeof(EClass))) {
				// create EntityGen
				var CharSequence content = compileEntitiesGen(e);	
				createFile(entityFolder, e.name + "Gen.java", true, content, progressMonitor);	
				
				// create Entity
				content = compileEntities(e)
				createFile(entityFolder, e.name + ".java", false, content, progressMonitor);	
			}
			makeProgressAndCheckCanceled(progressMonitor);
			
			createFile(project.getFolder("/META-INF"), "persistence.xml", true, compilePersistenceXML(resourceEcore), progressMonitor);	
			
			// finish the progress monitor
			progressMonitor.done;
		
		} catch (Exception ex) {
			ex.printStackTrace;
		}
	}
	
	def void makeProgressAndCheckCanceled(IProgressMonitor monitor) {
		monitor.worked(1);
		if (monitor.canceled) {
			throw new RuntimeException("Progress canceled");
		}
	}
	
	def compileEntitiesGen(EClass e) {
		'''
			package «PACKAGE»entities;
			
			/**
			* This is the {@link «e.name»} entity class.
			*
			*@generated
			*/
			public class «e.name»Gen «IF !e.EAllSuperTypes.empty» extends «e.EAllSuperTypes.head.name» «ENDIF» {
			
				// attributes
				«FOR a : e.EAllAttributes»
					/**
					* This is the «a.name» attribute.
					*/
					private «a.EType.instanceTypeName» «a.name»;
				«ENDFOR»
				
				// references
				«FOR a : e.EAllReferences.filter[!many]»
					private «a.EReferenceType.name» «a.name»;
				«ENDFOR»
				«FOR a : e.EAllReferences.filter[many]»
					private java.util.ArrayList<«a.EReferenceType.name»> «a.name»;
				«ENDFOR»
				
				/**
				* Default constructor.
				*/
				public «e.name»Gen() {
				}
				
				«IF !e.EAllAttributes.empty»
					/**
					* Constructor for all attributes.
					*/
					public «e.name»Gen(«FOR a : e.EAllAttributes SEPARATOR ', '» «a.EType.instanceTypeName» «a.name» «ENDFOR») {
						«FOR a : e.EAllAttributes»
							this.«a.name» = «a.name»;
						«ENDFOR»
					}
				«ENDIF»
				
				«IF !e.EAllAttributes.empty && !e.EAllReferences.empty»
					/**
					* Full constructor.
					*/
					public «e.name»Gen(
					«FOR a : e.EAllAttributes SEPARATOR ', '» «a.EType.instanceTypeName» «a.name» «ENDFOR» 
					«FOR a : e.EAllReferences.filter[!many] BEFORE ', ' SEPARATOR ', '» «a.EReferenceType.name» «a.name» «ENDFOR»
					«FOR a : e.EAllReferences.filter[many] BEFORE ', ' SEPARATOR ', '» java.util.ArrayList<«a.EReferenceType.name»> «a.name» «ENDFOR») {
					«FOR a : e.EAllAttributes + e.EAllReferences»
						this.«a.name» = «a.name»;
					«ENDFOR»
					}
				«ENDIF»
				
				«FOR a : e.EAllAttributes»	
					public «a.EType.instanceTypeName» get«a.name.toFirstUpper»() {
						return «a.name»;
					}
					
					public void set«a.name.toFirstUpper»(«a.EType.instanceTypeName» «a.name») {
						this.«a.name» = «a.name»;
					}
				«ENDFOR»
				
				«FOR a : e.EAllReferences.filter[!many]»
					public «a.EReferenceType.name» get«a.name.toFirstUpper»() {
						return «a.name»;
					}
					
					public void set«a.name.toFirstUpper»(«a.EReferenceType.name» «a.name») {
						this.«a.name» = «a.name»;
					}
				«ENDFOR»
				«FOR a : e.EAllReferences.filter[many]»
					public java.util.ArrayList<«a.EReferenceType.name»> get«a.name.toFirstUpper»() {
						return «a.name»;
					}
					
					public void set«a.name.toFirstUpper»(ArrayList<«a.EReferenceType.name»> «a.name») {
						this.«a.name» = «a.name»;
					}
				«ENDFOR»
				
				@Override
				public String toString() {
					«IF e.EAllAttributes.exists[string]»
						StringBuilder builder = new StringBuilder();
						«FOR a : e.EAllAttributes.filter[string]»
							builder.append(«a.name»);
							builder.append(" - ");
						«ENDFOR»
						return builder.toString();
					«ELSE»
						return null; //TODO
					«ENDIF»
				}
			
			}
		'''
	}
	
	def compileEntities(EClass e) {
		'''
			package «PACKAGE»entities;
			
			public class «e.name» extends «e.name»Gen {
				
			}
		'''
	}
	
	def compilePersistenceXML(Resource r) {
		'''
			<?xml version="1.0" encoding="UTF-8"?>
			
			<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" 
						 version="2.1" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
						 xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence       http://www.oracle.com/webfolder/technetwork/jsc/xml/ns/persistence/persistence_2_1.xsd">
						

				<!-- main unit -->
				<persistence-unit name="mainunit" transaction-type="RESOURCE_LOCAL">
					<provider>
						org.eclipse.persistence.jpa.PersistenceProvider
					</provider>
			
					<!-- entities -->
					«FOR e : r.allContents.toIterable.filter(typeof(EClass))»
						<class>«PACKAGE»entities.«e.name»</class>
					«ENDFOR»
					
					<properties>
						<!-- SQL print on console -->
						<!--<property name="eclipselink.logging.level.sql" value="FINEST"/> <property 
							name="eclipselink.logging.parameters" value="true"/> -->
			
						<property name="eclipselink.weaving" value="static"/>
						<property name="javax.persistence.lock.timeout" value="5000"/>
						<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
						<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/«getDBSchema»"/>
						<property name="javax.persistence.jdbc.user" value="root"/>
						<property name="javax.persistence.jdbc.password" value=""/>
						<property name="eclipselink.cache.shared.default" value="false"/>
						<!-- <property name="eclipselink.ddl-generation" value="create-tables"/>
						<property name="eclipselink.ddl-generation.output-mode" value="database"/> -->
					</properties>
				</persistence-unit>
			
			</persistence>
		'''
	}	
	
	def getDBSchema() {
		var persistenceConfig = this.metaModelResource.allContents.toIterable.filter(typeof(PersistenceConfig)).head;
		
		if (persistenceConfig === null) return "Hallo_Welt";
		
		return persistenceConfig.dbschema;
	}
	
	def getJSBCUserName() {
		var persistenceConfig = this.metaModelResource.allContents.toIterable.filter(typeof(PersistenceConfig)).head;
		
		if (persistenceConfig === null) return "Hallo_Welt";
		
		return persistenceConfig.jdbcUserName;
	}
	
	def isString(EAttribute a) {
		a.EAttributeType.classifierID == EcorePackage.ESTRING
	}
	
}