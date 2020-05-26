package hwp

import java.util.List

class Vector {
	List<Integer> components;
	
	new(List<Integer> components) {
		this.components = components;
	}
	
	def operator_doubleArrow(int i) {
		if (i > components.size()) {
			throw new IllegalArgumentException("Out of bounds")
		}
		
		return components.get(i)
	}
	
	def Vector operator_plus(Vector other) {
		if (this.components.size != other.components.size) {
			throw new IllegalArgumentException("Dimensions are incompatible!")
		}
		
		var List<Integer> newComponents = newArrayList()		
		for (var i = 0; i < this.components.size; i++) {
			newComponents.add((this => i) + (other => i))
		}
		
		return new Vector(newComponents)
	}	
	
	def int operator_multiply(Vector other) {
		if (this.components.size != other.components.size) {
			throw new IllegalArgumentException("Dimensions are incompatible!")
		}
		
		var int scalar = 0				
		for (var i = 0; i < this.components.size; i++) {
			scalar += (this => i) * (other => i)
		}
		
		return scalar		
	}
	
	def Vector operator_multiply(int scalar) {
		var List<Integer> newComponents = this.components.map[ c | c * scalar ]		
		return new Vector(newComponents)
	}
	
	override toString() {
		return "<" + components + ">"
	}

}