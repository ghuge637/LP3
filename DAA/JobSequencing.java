package DAA;
//2. Implement job sequencing with deadlines using a greedy method.
import java.util.Arrays;
import java.util.Comparator;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static void jobScheduling(Job[] jobs) {
        
        // Step 1: Sort jobs by profit descending
        Arrays.sort(jobs, Comparator.comparingInt(j -> -j.profit));

        // Step 2: Find max deadline to create slots
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        char[] result = new char[maxDeadline + 1]; 
        boolean[] slot = new boolean[maxDeadline + 1];

        int totalProfit = 0;

        // Step 3: Assign each job to the last possible free slot
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.print("Selected Jobs in order: ");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slot[i]) {
                System.out.print(result[i] + " ");
            }
        }

        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {

        Job[] jobs = {
                new Job('A', 2, 100),
                new Job('B', 1, 19),
                new Job('C', 2, 27),
                new Job('D', 1, 25),
                new Job('E', 3, 15)
        };

        jobScheduling(jobs);
    }
}
