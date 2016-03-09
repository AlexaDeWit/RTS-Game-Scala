local BarracksConstructor = {}

BarracksConstructor.tileset = love.graphics.newImage( "Assets/BuildingsAndUnits/Human/Buildings/barracks.png" )
BarracksConstructor.width = 64
BarracksConstructor.height = 64
BarracksConstructor.maxHP = 800
BarracksConstructor.healthRegen = 0
BarracksConstructor.armor = 2
BarracksConstructor.buildTime = 40
BarracksConstructor.attack = nil
BarracksConstructor.buildCost = {
  wood = 150,
  gold = 0
}
BarracksConstructor.visionRange = 3


function BarracksConstructor.new( owner )
  local Barracks = {}

  Barracks.hp = BarracksConstructor.maxHP

  function Barracks.getOwner()
    return owner
  end

  return Barracks
end

return BarracksConstructor
