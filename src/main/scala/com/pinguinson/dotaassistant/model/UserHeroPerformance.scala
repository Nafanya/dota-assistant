package com.pinguinson.dotaassistant.model

/**
  * Created by pinguinson on 6/10/2017.
  */
case class UserHeroPerformance(userId: String, hero: String, gamesPlayed: Int, winrate: Double) extends UserReport
