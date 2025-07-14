import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException
    {
        boolean playAgain = true;
        while (playAgain)
        {
            Scanner sc = new Scanner(System.in);
            int sc1 = 0;
            int sc2 = 0;
            int n;
            System.out.println("--------------------------- Welcome to my Casino ---------------------------");
            System.out.print("Please enter number between 7 to 10 : ");
            n = sc.nextInt();
            while (n < 7 || n > 10)
            {
                System.out.print("You entered an incorrect value. Please try again: ");
                n = sc.nextInt();
            }
            Stack MainStack = new Stack(1000);
            Stack TakenStack = new Stack(1000);
            Stack S1 = new Stack(13);
            Stack MainStack2 = new Stack(1000);
            Stack TakenStack2 = new Stack(1000);
            Stack S2 = new Stack(13);

            Queue Q3MainQueue = new Queue(1000);
            Queue Q3TempQueue = new Queue(1000);
            Queue Q4MainTempQueue = new Queue(1000);
            Queue Q4 = new Queue(1000);
            Queue selected = new Queue(1000);
            Queue tempSelected = new Queue(1000);

            for (int i = 1; i <= 13; i++) {
                MainStack.push(i);
                MainStack2.push(i);
            }
            //Selecting a random value for Player 1
            int a = n;
            Random random = new Random();
            int stackSize = 13;
            while (n > 0) {
                int randIndex = random.nextInt(stackSize);
                for (int i = 0; i < stackSize; i++) {
                    if (!(i == randIndex)) {
                        TakenStack.push(MainStack.pop());
                    } else {
                        S1.push(MainStack.pop());
                        n--;
                    }
                }
                while (!TakenStack.isEmpty()) {
                    MainStack.push(TakenStack.pop());
                }
                stackSize--;
            }
            //Selecting a random value for Player 2
            n = a;
            int stackSize2 = 13;
            while (n > 0) {
                int randIndex2 = random.nextInt(stackSize2);
                for (int i = 0; i < stackSize2; i++) {
                    if (!(i == randIndex2)) {
                        TakenStack2.push(MainStack2.pop());
                    } else {
                        S2.push(MainStack2.pop());
                        n--;
                    }
                }
                while (!TakenStack2.isEmpty()) {
                    MainStack2.push(TakenStack2.pop());
                }
                stackSize2--;
            }
            while (!MainStack.isEmpty())
                MainStack.pop();

            while (!MainStack2.isEmpty())
                MainStack2.pop();


            // Player 1 Sort
            while (!S1.isEmpty()) {
                int tmp1 = (int) S1.pop();
                while (!MainStack.isEmpty() && (int) MainStack.peek() > tmp1) {
                    S1.push(MainStack.pop());
                }
                MainStack.push(tmp1);
            }
            //Player 2 Sort
            while (!S2.isEmpty())
            {
                int tmp2 = (int) S2.pop();
                while (!MainStack2.isEmpty() && (int) MainStack2.peek() > tmp2)
                {
                    S2.push(MainStack2.pop());
                }
                MainStack2.push(tmp2);
            }
            //to convert char values to int for Player 1
            while (!MainStack.isEmpty()) {
                if ((int) MainStack.peek() == 1) {
                    S1.push("A");
                    MainStack.pop();
                } else if ((int) MainStack.peek() == 11) {
                    S1.push("J");
                    MainStack.pop();
                } else if ((int) MainStack.peek() == 12) {
                    S1.push("Q");
                    MainStack.pop();

                } else if ((int) MainStack.peek() == 13) {
                    S1.push("K");
                    MainStack.pop();

                } else {
                    S1.push(MainStack.pop());
                }
            }
            //to convert char values to int for Player 2
            while (!MainStack2.isEmpty()) {
                if ((int) MainStack2.peek() == 1) {
                    S2.push("A");
                    MainStack2.pop();
                } else if ((int) MainStack2.peek() == 11) {
                    S2.push("J");
                    MainStack2.pop();
                } else if ((int) MainStack2.peek() == 12) {
                    S2.push("Q");
                    MainStack2.pop();
                } else if ((int) MainStack2.peek() == 13) {
                    S2.push("K");
                    MainStack2.pop();
                } else {
                    S2.push(MainStack2.pop());
                }
            }

            //Filling the inside with Q3 and Q4Temp.
            Q3MainQueue.enqueue("A");
            Q4MainTempQueue.enqueue("A");
            for (int i = 2; i < 11; i++) {
                Q4MainTempQueue.enqueue(i);
                Q3MainQueue.enqueue(i);
            }
            Q4MainTempQueue.enqueue("J");
            Q4MainTempQueue.enqueue("Q");
            Q4MainTempQueue.enqueue("K");
            Q3MainQueue.enqueue("J");
            Q3MainQueue.enqueue("Q");
            Q3MainQueue.enqueue("K");

            //Write the Player 1, Score and Bag 1.
            System.out.print("Player 1: ");
            while (!S1.isEmpty())
            {
                System.out.print(S1.peek() + " ");
                MainStack.push(S1.pop());
            }
            while (!MainStack.isEmpty())
            {
                S1.push(MainStack.pop());
            }
            System.out.print("         Score: " + sc1);
            System.out.print("         Bag 1: ");
            while (!Q3MainQueue.isEmpty())
            {
                System.out.print(Q3MainQueue.peek() + " ");
                Q3TempQueue.enqueue(Q3MainQueue.dequeue());
            }
            while (!Q3TempQueue.isEmpty())
            {
                Q3MainQueue.enqueue(Q3TempQueue.dequeue());
            }

            System.out.println();
            //Selecting a random value for Bag 1
            int queueSize = 13;
            while (queueSize > 0) {
                int randIndex = random.nextInt(queueSize);
                for (int i = 0; i < queueSize; i++) {
                    if (!(i == randIndex)) {
                        Q3TempQueue.enqueue(Q4MainTempQueue.dequeue());
                    } else {
                        Q4.enqueue(Q4MainTempQueue.dequeue());
                    }
                }
                while (!Q3TempQueue.isEmpty()) {
                    Q4MainTempQueue.enqueue(Q3TempQueue.dequeue());
                }
                queueSize--;
            }
            while (!Q4MainTempQueue.isEmpty())
                Q4MainTempQueue.dequeue();

            //Sort
            while (!Q4MainTempQueue.isEmpty())
            {
                int tmp3 = (int) Q4MainTempQueue.dequeue();
                while (!Q4MainTempQueue.isEmpty() && (int) Q4MainTempQueue.peek() > tmp3)
                {
                    Q4MainTempQueue.enqueue(Q4MainTempQueue.dequeue());
                }
                Q4MainTempQueue.enqueue(tmp3);
            }

            //Write the Player 2, Score and Bag 2
            System.out.print("Player 2: ");
            while (!S2.isEmpty())
            {
                System.out.print(S2.peek() + " ");
                MainStack2.push(S2.pop());
            }
            while (!MainStack2.isEmpty())
            {
                S2.push(MainStack2.pop());
            }
            System.out.print("         Score: " + sc2);
            System.out.print("         Bag 2: ");


            //First Tournament
            int score1 = 0;
            int score2 = 0;
            int count = 1;
            n = a;
            while (!(S1.size() == n - 4 || S2.size() == n - 4))
            {
                Object select = Q4.peek();
                selected.enqueue(Q4.dequeue());
                System.out.println();
                System.out.println();
                System.out.println(count + ". Selected value: " + select);
                count += 1;
                boolean flag1 = false;
                boolean flag2 = false;

                //Delete Player 2
                while (!S2.isEmpty())
                {
                    if (!(S2.peek() == select))
                    {
                        MainStack2.push(S2.pop());
                    }
                    else
                    {
                        S2.pop();
                        score2 = score2 + 10;
                        flag2 = true;
                    }
                }
                while (!MainStack2.isEmpty())
                {
                    S2.push(MainStack2.pop());
                }
                if (!flag2)
                {
                    score2 -= 5;
                }

                //Delete Player 1
                while (!S1.isEmpty())
                {
                    if (!(S1.peek() == select))
                    {
                        MainStack.push(S1.pop());
                    }
                    else
                    {
                        S1.pop();
                        score1 += 10;
                        flag1 = true;
                    }
                }
                while (!MainStack.isEmpty())
                {
                    S1.push(MainStack.pop());
                }
                if (!flag1)
                {
                    score1 -= 5;
                }

                System.out.print("Player 1: ");
                while (!S1.isEmpty())
                {
                    MainStack.push(S1.peek());
                    System.out.print(S1.pop() + " ");
                }
                while (!MainStack.isEmpty())
                {
                    S1.push(MainStack.pop());
                }
                System.out.print("        Score 1: " + score1);
                System.out.print("        Bag 1: ");

                while (!Q3MainQueue.isEmpty())
                {
                    if (Q3MainQueue.peek() == select)
                        Q3MainQueue.dequeue();
                    else
                    {
                        System.out.print(Q3MainQueue.peek() + " ");
                        Q3TempQueue.enqueue(Q3MainQueue.dequeue());
                    }
                }
                while (!Q3TempQueue.isEmpty())
                {
                    Q3MainQueue.enqueue(Q3TempQueue.dequeue());
                }

                System.out.println(" ");
                System.out.print("Player 2: ");

                while (!S2.isEmpty())
                {
                    MainStack2.push(S2.peek());
                    System.out.print(S2.pop() + " ");
                }
                while (!MainStack2.isEmpty())
                {
                    S2.push(MainStack2.pop());
                }
                System.out.print("        Score 2: " + score2);
                System.out.print("        Bag 2: ");
                while (!selected.isEmpty())
                {
                    System.out.print(selected.peek() + " ");
                    tempSelected.enqueue(selected.dequeue());
                }
                while (!tempSelected.isEmpty())
                {
                    selected.enqueue(tempSelected.dequeue());
                }
            }

            System.out.println();
            System.out.println();
            System.out.println("First tournament is completed!!");
            //Scores
            if (S1.size() == n - 4 && S2.size() == n - 4)
            {
                score1 += 15;
                score2 += 15;

            }
            else if (S1.size() == n - 4)
            {
                score1 += 30;

            }
            else if (S2.size() == n - 4)
            {
                score2 += 30;
            }
            System.out.println();

            System.out.print("Player 1: ");
            while (!S1.isEmpty())
            {
                MainStack.push(S1.peek());
                System.out.print(S1.pop() + " ");
            }
            while (!MainStack.isEmpty())
            {
                S1.push(MainStack.pop());
            }
            System.out.print("        Score 1: " + score1);
            System.out.print("        Bag 1: ");
            while (!Q3MainQueue.isEmpty())
            {
                System.out.print(Q3MainQueue.peek() + " ");
                Q3TempQueue.enqueue(Q3MainQueue.dequeue());
            }
            while (!Q3TempQueue.isEmpty())
            {
                Q3MainQueue.enqueue(Q3TempQueue.dequeue());
            }

            System.out.println();
            System.out.print("Player 2: ");
            while (!S2.isEmpty())
            {
                MainStack2.push(S2.peek());
                System.out.print(S2.pop() + " ");
            }
            while (!MainStack2.isEmpty())
            {
                S2.push(MainStack2.pop());
            }
            System.out.print("        Score 2: " + score2);
            System.out.print("        Bag 2: ");

            while (!selected.isEmpty())
            {
                System.out.print(selected.peek() + " ");
                tempSelected.enqueue(selected.dequeue());
            }
            while (!tempSelected.isEmpty())
            {
                selected.enqueue(tempSelected.dequeue());
            }

            //Second Tournament
            while (!(S1.size() == 0 || S2.size() == 0))
            {
                Object select = Q4.peek();
                selected.enqueue(Q4.dequeue());
                System.out.println();
                System.out.println();
                System.out.println(count + ". Selected value: " + select);
                count += 1;
                boolean flag1 = false;
                boolean flag2 = false;

                //Delete Player 2
                while (!S2.isEmpty())
                {
                    if (!(S2.peek() == select))
                    {
                        MainStack2.push(S2.pop());
                    }
                    else
                    {
                        S2.pop();
                        score2 = score2 + 10;
                        flag2 = true;
                    }
                }
                while (!MainStack2.isEmpty())
                {
                    S2.push(MainStack2.pop());
                }
                if (!flag2)
                {
                    score2 -= 5;
                }

                //Delete Player 1
                while (!S1.isEmpty())
                {
                    if (!(S1.peek() == select))
                    {
                        MainStack.push(S1.pop());
                    }
                    else
                    {
                        S1.pop();
                        score1 += 10;
                        flag1 = true;
                    }
                }
                while (!MainStack.isEmpty())
                {
                    S1.push(MainStack.pop());
                }
                if (!flag1)
                {
                    score1 -= 5;
                }

                System.out.print("Player 1: ");
                while (!S1.isEmpty())
                {
                    MainStack.push(S1.peek());
                    System.out.print(S1.pop() + " ");
                }
                while (!MainStack.isEmpty())
                {
                    S1.push(MainStack.pop());
                }
                System.out.print("        Score 1: " + score1);
                System.out.print("        Bag 1: ");
                while (!Q3MainQueue.isEmpty())
                {
                    if (Q3MainQueue.peek() == select)
                        Q3MainQueue.dequeue();
                    else
                    {
                        System.out.print(Q3MainQueue.peek() + " ");
                        Q3TempQueue.enqueue(Q3MainQueue.dequeue());
                    }
                }
                while (!Q3TempQueue.isEmpty())
                {
                    Q3MainQueue.enqueue(Q3TempQueue.dequeue());
                }

                System.out.println();
                System.out.print("Player 2: ");
                while (!S2.isEmpty())
                {
                    MainStack2.push(S2.peek());
                    System.out.print(S2.pop() + " ");
                }
                while (!MainStack2.isEmpty())
                {
                    S2.push(MainStack2.pop());
                }
                System.out.print("        Score 2: " + score2);
                System.out.print("        Bag 2: ");

                while (!selected.isEmpty())
                {
                    System.out.print(selected.peek() + " ");
                    tempSelected.enqueue(selected.dequeue());
                }
                while (!tempSelected.isEmpty())
                {
                    selected.enqueue(tempSelected.dequeue());
                }
            }
            //End of the game.
            System.out.println();
            System.out.println();
            System.out.println("Game Over");
            System.out.println();
            //Scores
            if (S1.size() == 0 && S2.size() == 0)
            {
                score1 += 25;
                score2 += 25;

            }
            else if (S1.size() == 0)
            {
                score1 += 50;

            }
            else if (S2.size() == 0)
            {
                score2 += 50;
            }
            //Find the winner
            if (score1 > score2)
            {
                System.out.println("Winner: Player 1 with " + score1 + " points");
            }
            else if (score2 > score1)
            {
                System.out.println("Winner: Player 2 with " + score2 + " points");
            }
            else
            {
                System.out.println("The game is over without any winner.Tie.");
            }

            System.out.println();
            System.out.println("What is your name? : ");
            String name = sc.next();

            //HighScore Table
            Queue Q1names = new Queue(1000);
            Queue Q2scores = new Queue(1000);
            Queue namesTemp = new Queue(1000);
            Queue scoresTemp = new Queue(1000);
            Scanner scanner = new Scanner(new File("D:\\\\HighScoreTable.txt"));
            while (scanner.hasNextLine() && Q2scores.size() < 12)
            {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                Q1names.enqueue(parts[0]);
                Q2scores.enqueue(Integer.parseInt(parts[1]));
            }
            while (!Q1names.isEmpty())
            {
                namesTemp.enqueue(Q1names.dequeue());
            }
            while (!Q2scores.isEmpty())
            {
                scoresTemp.enqueue(Q2scores.dequeue());
            }
            while (!namesTemp.isEmpty() && !scoresTemp.isEmpty())
            {
                System.out.println(namesTemp.dequeue() + " " + scoresTemp.dequeue());
            }
            System.out.println();
            //Play again?
            System.out.println("Play again?");
            String option = sc.next();
            if (option.equalsIgnoreCase("Y"))
            {
                playAgain = true;
            }
            else if (option.equalsIgnoreCase("N"))
            {
                playAgain = false;
            }
        }
    }
}

