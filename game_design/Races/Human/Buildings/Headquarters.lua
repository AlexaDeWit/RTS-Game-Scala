local class = require( "Lib/middleclass" )
local PlayerStructure = require( "Src/PlayerStructure" )
local Headquarters = class("Headquarters", PlayerStructure)

Headquarters.static.tileset = love.graphics.newImage( "Assets/BuildingsAndUnits/Human/Buildings/hq2.png" )
Headquarters.static.maxHP = 1250
Headquarters.static.healthRegen = 0
Headquarters.static.armor = 2
Headquarters.static.buildTime = 60
Headquarters.static.attack = nil
Headquarters.static.buildCost = {
  wood = 500,
  gold = 0
}
Headquarters.static.visionRange = 8

function Headquarters:initialize( owner )
  self.owner = owner
  self.setActorData( Headquarters, Headquarters.tileset, 96, 96 )
  self.hp = Headquarters.maxHP
end

function Headquarters:getOwner()
  return self.owner
end

return Headquarters
