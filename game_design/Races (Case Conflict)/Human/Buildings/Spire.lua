local SpireConstructor = {}

SpireConstructor.tileset = love.graphics.newImage( "Assets/BuildingsAndUnits/Human/Buildings/spire.png" )
SpireConstructor.width = 64
SpireConstructor.height = 64
SpireConstructor.maxHP = 750
SpireConstructor.healthRegen = 0
SpireConstructor.armor = 1
SpireConstructor.buildTime = 34
SpireConstructor.attack = nil
SpireConstructor.buildCost = {
  wood = 200,
  gold = 150
}
SpireConstructor.visionRange = 5


function SpireConstructor.new( owner )
  local Spire = {}

  Spire.hp = SpireConstructor.maxHP

  function Spire.getOwner()
    return owner
  end

  return Spire
end

return SpireConstructor
