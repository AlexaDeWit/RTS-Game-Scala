local TowerConstructor = {}

TowerConstructor.tileset = love.graphics.newImage( "Assets/BuildingsAndUnits/Human/Buildings/tower.png" )
TowerConstructor.width = 32
TowerConstructor.height = 32
TowerConstructor.maxHP = 400
TowerConstructor.healthRegen = 0
TowerConstructor.armor = 3
TowerConstructor.buildTime = 34
TowerConstructor.attack = nil
TowerConstructor.buildCost = {
  wood = 150,
  gold = 0
}
TowerConstructor.visionRange = 7


function TowerConstructor.new( owner )
  local Tower = {}

  Tower.hp = TowerConstructor.maxHP

  function Tower.getOwner()
    return owner
  end

  return Tower
end

return TowerConstructor
