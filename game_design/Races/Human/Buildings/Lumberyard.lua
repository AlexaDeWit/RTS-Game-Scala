local LumberyardConstructor = {}

LumberyardConstructor.tileset = love.graphics.newImage( "Assets/BuildingsAndUnits/Human/Buildings/lumberyard.png" )
LumberyardConstructor.width = 64
LumberyardConstructor.height = 64
LumberyardConstructor.maxHP = 700
LumberyardConstructor.healthRegen = 0
LumberyardConstructor.armor = 1
LumberyardConstructor.buildTime = 30
LumberyardConstructor.attack = nil
LumberyardConstructor.buildCost = {
  wood = 150,
  gold = 0
}
LumberyardConstructor.visionRange = 3


function LumberyardConstructor.new( owner )
  local Lumberyard = {}

  Lumberyard.hp = LumberyardConstructor.maxHP

  function Lumberyard.getOwner()
    return owner
  end

  return Lumberyard
end

return LumberyardConstructor
