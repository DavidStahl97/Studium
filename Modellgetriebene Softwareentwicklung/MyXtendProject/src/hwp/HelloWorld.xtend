package hwp

class HelloWorld {
	def static void main(String[] args) {
		var v1 = new Vector(newArrayList(1, 2, 3))
		var v2 = new Vector(newArrayList(3, 2, 1))
		
		var v3 = v1 * v2
		println(v3)
		
		var v4 = v1 * 10
		println(v4)	
					
	}
	
	override toString() {
		return "I am instance of HelloWorld" + super.toString()
	}
}