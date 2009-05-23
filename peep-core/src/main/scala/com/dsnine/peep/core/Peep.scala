package com.dsnine.peep.core

import org.scala_libs.jpa._

object EMF extends LocalEMF("peep") 

object Peep {
	def withEM[T](fun:(ScalaEntityManager) => T):T = {
		val em = EMF.newEM
		try {
			return fun(em)
		} finally {
			em.close()		
		}
	}
}

object Bootstrap {
	def bootstrap {
		Peep.withEM { em =>
			val u1 = new User()	
			u1.name = "Dominik"

			val u2 = new User()	
			u2.name = "David"

			val u3 = new User()	
			u3.name = "Dirk"

			val m1 = new Message()
			m1.text = "Tschüssn"
			m1.author = u1

			em.persist(u1)
			em.persist(u2)
			em.persist(u3)

			em.flush()

			em.persist(m1)		
			
			u1.followers.add(u2)
			u1.followers.add(u3)

			u2.followers.add(u3)

			em.flush()
		}
	}
}
