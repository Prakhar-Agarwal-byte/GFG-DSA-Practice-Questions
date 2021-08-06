
// Java program to find the distance
// between two nodes in an infinite
// binary tree
class GFG
{

// function to find the distance
// between two nodes in an infinite
// binary tree
static int Distance(int x, int y)
{
    // swap the smaller
    if (x < y)
    {
        int temp = x;
        x = y;
        y = temp;
    }
    int c = 0;

    // divide till x!=y
    while (x != y) 
    {

        // keep a count
        ++c;

        // perform division
        if (x > y)
            x = x >> 1;

        // when the smaller
        // becomes the greater
        if (y > x) 
        {
            y = y >> 1;
            ++c;
        }
    }
    return c;
}
