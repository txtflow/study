package coherence

import com.tangosol.net.CacheFactory
import model.Country
import scala.collection.JavaConversions._
import com.tangosol.util.filter.LikeFilter
import java.util.Map.{Entry => MapEntry}

object Main {
  def main(args: Array[String]) {
    val countries = CacheFactory.getCache("countries")

    countries.put("USA", new Country("USA", "United States",
      "Washington", "USD", "Dollar"));
    countries.put("GBR", new Country("GBR", "United Kingdom",
      "London", "GBP", "Pound"));
    countries.put("RUS", new Country("RUS", "Russia", "Moscow",
      "RUB", "Ruble"));
    countries.put("CHN", new Country("CHN", "China", "Beijing",
      "CNY", "Yuan"));
    countries.put("JPN", new Country("JPN", "Japan", "Tokyo",
      "JPY", "Yen"));
    countries.put("DEU", new Country("DEU", "Germany", "Berlin",
      "EUR", "Euro"));
    countries.put("FRA", new Country("FRA", "France", "Paris",
      "EUR", "Euro"));
    countries.put("ITA", new Country("ITA", "Italy", "Rome",
      "EUR", "Euro"));
    countries.put("SRB", new Country("SRB", "Serbia", "Belgrade",
      "RSD", "Dinar"));

    // get and print a single country
    println("get(SRB) = " + countries.get("SRB"));
    // remove Italy from the cache
    val size = countries.size();

    // list all cache entries
    countries.entrySet(new LikeFilter("name", "United%"), null) foreach {
      case e: MapEntry[_,_] => println(e.getKey + " = " + e.getValue)
    }
  }
}