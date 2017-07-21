package algorithms.mishra.dev.rahul.quora.stack;


import java.util.Stack;

/**
 * Created by aleesha on 20/07/17.
 */
public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        QueueImpl queue = new QueueUsingTwoStacks().new QueueImpl();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.offer(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    class QueueImpl {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public QueueImpl() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void offer(int data) {
            inStack.push(data);
        }

        public int poll() {
            if(outStack.isEmpty()) {
                while(!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            if(outStack.isEmpty()) {
                throw new RuntimeException("There are no elements present in queue to poll!!!");
            }
            return outStack.pop();
        }

    }
}
