public abstract class Polygon{
    public long sides[];

    public Polygon(long ...side_lengths){

        this.sides = new long[this.sideCount()];
        for(int i=0; i<side_lengths.length; i++){
            this.sides[i] = side_lengths[i];
        }
    }

    public abstract int sideCount(); // Returns 3 for triangle, 4 for rectangle

}