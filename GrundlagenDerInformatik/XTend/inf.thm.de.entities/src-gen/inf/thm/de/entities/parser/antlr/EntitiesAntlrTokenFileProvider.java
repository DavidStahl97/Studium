/*
 * generated by Xtext 2.18.0
 */
package inf.thm.de.entities.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class EntitiesAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("inf/thm/de/entities/parser/antlr/internal/InternalEntities.tokens");
	}
}
