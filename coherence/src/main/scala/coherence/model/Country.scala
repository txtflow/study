package coherence.model

case class Country(
  code: String,
  name: String,
  capital: String,
  currencySymbol: String,
  currencyName: String)
  extends  Ordered[Country] {

  def compare(that: Country) = name.compareTo(that.name)
}