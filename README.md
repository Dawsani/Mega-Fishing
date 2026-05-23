# Summary
This mod modifies the minecraft fishing treasure loot pool to contain mega stones from the Mega Showdown and Navas' ZAmega mods without overwriting the fishing treasure loot pool. 

# Odds
- For each treasure caught by the player, there is a 1/16 chance to also catch a random mega stone
- For each treasure caught there is a 1/160 chance to also catch a blank mega stone
- These values can be modified in the config

# Legendary Mega Stones
This mod does not include the 10 legendary mega stones in this fishing treasure loot pool. If having those stones added to the loot pool is of interest of you, send me a message about it.

# Config Information
The config file is named "mega-fishing.json" and is placed in your config directory.

These are the config file options:
- megaStoneChance
  - Description: The probability that you get a random mega stone whenever you catch a treasure while fishing.
  - Default Value: 0.0625 (1/16)
- blankMegaStoneChance
  - Description: The probability that you get a blank mega stone whenever you catch a treasure while fishing.
  - Default Value: 0.00625 (1/160)

# Verification

One quick way to verify the mod is working properly is to enable cheats and test the following commands. The first should give the player a random mega stone, and the second should give the player a blank mega stone.

1. `/loot give @p loot megafishing:gameplay/fishing/mega_stones`
2. `/loot give @p loot megafishing:gameplay/fishing/blank_mega_stone`

# Requirements

- Cobblemon: Mega Showdown
  - Versions: Any
- Navas ZA Mega
  - Versions: >= 1.7.0

Happy fishing :)
