# Zombie Simulator

**Assignment 5 — Object-Oriented Programming in Java**

This project simulates a **zombie infection** spreading across a 2D plane.  
Each entity moves randomly, and when a zombie touches a non-zombie, the infection spreads.  
The program visually represents the process using the `StdDraw` library.

---

## Overview

The simulator reads entity data (zombies and non-zombies) from an input file, displays them as dots, and updates their positions over time.  
When all entities have become zombies, the simulation ends.

---

## Classes

### `ZombieSimulator.java`
Main simulation class — handles:
- Reading entity data from a file
- Random movement within bounds
- Zombie infection logic
- Display and animation using `StdDraw`

### `DrawEntitiesDebugApp.java`
A helper app used for debugging entity positions and display using crosshairs.

---

## Features
- Visual simulation of entities moving on a 2D grid
- Zombies spread infection by contact
- Movement constrained within canvas boundaries
- Real-time updates using double buffering
- Displays remaining non-zombie count

---

## Key Methods

| Method | Description |
|--------|--------------|
| `readEntities()` | Reads entity types and positions from a file |
| `drawEntities()` | Draws zombies (red) and non-zombies (black) |
| `updateEntities()` | Randomly moves entities and updates infection states |
| `touchingZombie()` | Checks if a non-zombie is touching a zombie |
| `nonzombieCount()` | Returns the number of remaining non-zombies |
| `runSimulation()` | Controls the main simulation loop |

---

## 🧾 Example Input File Format
