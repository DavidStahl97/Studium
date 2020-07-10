

import java.util.Collection

class CollectionExtensions {
	def static <E> schnittmenge(Collection<E> collectionOne, Collection<E> collectionTwo) {
		return collectionOne.filter[c1 | collectionTwo.exists[c2 | c2.equals(c1)]];
	}
	
	def static <E> differenz(Collection<E> collectionOne, Collection<E> collectionTwo) {
		return collectionOne.filter[c1 | collectionTwo.exists[c2 | c2.equals(c1)] == false];
	}
	
	def static <E> vereinigung(Collection<E> collectionOne, Collection<E> collectionTwo) {
		return collectionOne.differenz(collectionTwo).toList().addAll(collectionTwo);
	}
	
	def static <E> symetrischeDifferenz(Collection<E> collectionOne, Collection<E> collectionTwo) {
		return collectionOne.differenz(collectionTwo).toList().addAll(collectionTwo.differenz(collectionOne));
	}
	
	def <E> operator_and(Collection<E> collectionOne, Collection<E> collectionTwo) {
		
		val s = collectionOne || collectionTwo;
		return schnittmenge(collectionOne, collectionTwo);
	}
	
	def <E> operator_minus(Collection<E> collectionOne, Collection<E> collectionTwo) {
		return differenz(collectionOne, collectionTwo);
	}
	
	def <E> operator_or(Collection<E> collectionOne, Collection<E> collectionTwo) {
		return vereinigung(collectionOne, collectionTwo);
	}
}