# Final Reality

Final Reality is a simplified clone of the renowned game, Final Fantasy. Its main purpose is to
serve as an educational tool, teaching foundational programming concepts.

This README is yours to complete it. Take this opportunity to describe your contributions, the
design decisions you've made, and any other information you deem necessary.

This project is licensed under the
[Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).

We've opted for a flexible design by defining Character as a trait. This decision allows for various character types to
be defined, each with its own set of attributes and abilities. For example, we've defined character types such as Ninja,
Warrior, Paladin,  etc., each with distinct values for attributes like livePoints, defending, weight, etc.
It was decided that our characters, ninjas, paladins, etc. will have the same characteristics, which is why they are 
initialized with names like life points, etc.

Magical Character Trait
To further enhance gameplay diversity, we've introduced the MagicalCharacter trait, which extends the 
Character trait. This allows characters to possess magical abilities in addition to their regular attributes.
By extending Character, magical characters inherit all the properties and methods defined in the base trait, enabling 
seamless integration of magical and non-magical characters within the game world.

For weaponry, it was also considered similar to the character package, defining a 'weapon' trait and another one that
extends from it called 'magicalWeapon', with each class already defining the name and data.