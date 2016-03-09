local BlacksmithConstructor = {}

BlacksmithConstructor.tileset = love.graphics.newImage( "Assets/BuildingsAndUnits/Human/Buildings/blacksmith.png" )
BlacksmithConstructor.width = 64
BlacksmithConstructor.height = 64
BlacksmithConstructor.maxHP = 850
BlacksmithConstructor.healthRegen = 0
BlacksmithConstructor.armor = 2
BlacksmithConstructor.buildTime = 42
BlacksmithConstructor.attack = nil
BlacksmithConstructor.buildCost = {
  wood = 125,
  gold = 50
}
BlacksmithConstructor.visionRange = 3


function BlacksmithConstructor.new( owner )
  local Blacksmith = {}

  Blacksmith.hp = BlacksmithConstructor.maxHP

  function Blacksmith.getOwner()
    return owner
  end

  return Blacksmith
end

return BlacksmithConstructor
