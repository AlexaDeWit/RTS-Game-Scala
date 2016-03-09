local GoldmineConstructor = {}

GoldmineConstructor.tileset = love.graphics.newImage( "Assets/BuildingsAndUnits/Human/Buildings/goldmine.png" )
GoldmineConstructor.width = 64
GoldmineConstructor.height = 64
GoldmineConstructor.maxHP = 500
GoldmineConstructor.healthRegen = 0
GoldmineConstructor.armor = 3
GoldmineConstructor.buildTime = 28
GoldmineConstructor.attack = nil
GoldmineConstructor.buildCost = {
  wood = 100,
  gold = 0
}
GoldmineConstructor.visionRange = 3


function GoldmineConstructor.new( owner )
  local Goldmine = {}

  Goldmine.hp = GoldmineConstructor.maxHP

  function Goldmine.getOwner()
    return owner
  end

  return Goldmine
end

return GoldmineConstructor
