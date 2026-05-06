//BFS traversal starting from A

//Step-by-step:

//Start: A
//Queue: [A]

//Visit A → add C, B, D
//Queue: [C, B, D]

//Visit C
//Queue: [B, D]

//Visit B → add E, G
//Queue: [D, E, G]

//Visit D
//Queue: [E, G]

//Visit E → add F
//Queue: [G, F]

//Visit G
//Queue: [F]

//Visit F

//Final BFS order:
//A C B D E G F
