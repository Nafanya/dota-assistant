package com.pinguinson.dotaassistant.services

import java.net.URL

import scala.io.Source
import scala.util.Try

/**
  * Dota log parser
  */
object LogParser {
  /**
    * Extracts 10 player IDs from the most recent lobby log
    *
    * @param path Path to the log file
    */
  def getLobbyPlayers(path: URL): Option[List[String]] = {

    def extractPlayerIds(str: String): List[String] = str.split("\\[U:1:").map(_.takeWhile(_ != ']')).slice(1, 11).toList

    for {
      logs <- Try(Source.fromURL(path).getLines.toList.reverse).toOption
      logLine <- logs.find(_.contains("Lobby"))
    } yield extractPlayerIds(logLine)
  }
}
