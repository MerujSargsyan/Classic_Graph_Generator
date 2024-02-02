# Classic_Graph_Generator
### Allows the user to generate classic graphs studied in graph theory

## Installation:
```
cd path/to/your/local/repository
git remote add origin https://github.com/MerujSargsyan/Classic_Graph_Generator
git pull origin main
#Files downloaded

# Compile
javac *.java
```

## Usage:

```
// generates a complete graph of size n
java Main -c n

// generates a complete bipartite graph with group 1 size A and group 2 size B       
java Main -c -b A,B

// help
java Main -h         
```

## Example:

```
// generates a complete graph with 5 vertecies
java Main -c 5

// generates a complete bipartite graph with group A of size 5 and group B of size 6
java Main -c -b 5,6
```

## What I learned:
<ul>
    <li> Using bezier curves to make clear connections </li>
    <li> Handling command line arguments of different sizes </li>
</ul>

### Thank You. Hope you enjoy :)
