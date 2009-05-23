package com.dsnine.peep.core

import Peep._

object UserService {
	def getUserById(id:Long):User = {
		withEM { _.find(classOf[User], id) } match {
			case Some(user) => user
			case None => null
		}
	}

	def getFollowersForUser(user:User):List[User] = {
		import scala.collection.jcl.Conversions._
		withEM { _.merge(user).followers.toList }

		/*
		withEM { em =>
			val mergedUser = em.merge(user)			
			mergedUser.followers.toList
		}
		*/
  }

	def getFollowedUsersForUser(user:User):List[User] = {
		withEM { em =>
			val query = em.createQuery[User]("FROM User u WHERE :user MEMBER OF u.followers")
    	query.setParameter("user", user)
			query.findAll.toList
		}
  }

}
