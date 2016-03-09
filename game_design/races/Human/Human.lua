local Human = {

  StartingBuilding = "Headquarters",
  Buildings = {
    Headquarters = require( "Src/Races/Human/Buildings/Headquarters" ),
    House        = require( "Src/Races/Human/Buildings/House" ),
    Barracks	 = require ( "Src/Races/Human/Buildings/Barracks" )
  }
}
return Human
