package Stack;

/**
 * Created by rajkamal on 12/7/16.
 */
public class stack_test {
    public static void test(){
        int [] arr1 = {12, 34, 56,  78, 90, 88, 77};
        int length1  = 7;
        int data = 0, size = 0, top = -1;
        FixedSizeArrayStack stack1 = new FixedSizeArrayStack(length1);

        for (int i = 0; i < length1; i++){
            try {
                stack1.push(arr1[i]);
            } catch (Exception ex){
                System.out.println("Push Exception");
            }
        }

        try {
            data = stack1.pop();
        } catch (Exception ex){
            System.out.println("pop Exception ");
        }

        size = stack1.size();

        try {
            top = stack1.top();
        }catch (Exception ex) {
            System.out.println("Top Exception");
        }
        System.out.println("Stack :");
        System.out.println(stack1.toString());
        System.out.println("Stack Size " + size);
        System.out.println("Stack Top : " + top);

        try {
            data = stack1.pop();
        } catch (Exception ex){
            System.out.println("pop Exception ");
        }

            size = stack1.size();

        try {
            top = stack1.top();
        }catch (Exception ex) {
            System.out.println("Top Exception");
        }

        System.out.println("Stack :");
        System.out.println(stack1.toString());
        System.out.println("Stack Size " + size);
        System.out.println("Stack Top : " + top);

        data = 0;

        try {
            stack1.push(data);
        } catch (Exception ex){
            System.out.println("Push Exception");
        }

            size = stack1.size();

        try {
            top = stack1.top();
        }catch (Exception ex) {
            System.out.println("Top Exception");
        }
        System.out.println("Stack :");
        System.out.println(stack1.toString());
        System.out.println("Stack Size " + size);
        System.out.println("Stack Top : " + top);



    }

    public static  void main(String[]args) {
        test();

    }
}
