import java.util.ArrayList;

public class Main {

    /*
    Animal Counter adds animals to animalList
    Fruit Counter writes 'N' fruits to console
     */

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ArrayList<String> animalList = new ArrayList<>();


        Counter fruitCounter = new Counter(10,20);
        Counter animalCounter = new Counter(23, 45);


        fruitCounter.setOnCountListner(new Counter.OnCountListner() {
            @Override
            public void onCount(int index) {
                System.out.println(index + " Fruits");
            }
        });

        animalCounter.setOnCountListner(new Counter.OnCountListner() {
            @Override
            public void onCount(int index) {
                animalList.add("Animal no." + index);
            }
        });

        fruitCounter.count();
        animalCounter.count();

        System.out.println("Total animals = " + animalList.size());

    }



    public static class Counter {
        int start, end;
        OnCountListner ocl;

        public void setOnCountListner (OnCountListner ocl) {
            this.ocl = ocl;
        }

        public interface OnCountListner {
            void onCount (int index);
        }

        public Counter(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void count () {

            for (int i = start; i < end; i++) {
                if (ocl != null) {
                    ocl.onCount(i);
                }
            }
        }
    }


}
