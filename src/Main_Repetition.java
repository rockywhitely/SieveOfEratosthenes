import java.io.IOException;

class Main_Repetition {
    public static void main(String[] args) throws IOException {
        // Scanner inp = new Scanner(System.in);
        // System.out.print("Input upper limit for generating a list of prime numbers: ");
        // int limit = inp.nextInt();

        // // check for limit of primes
        // while (limit < 2 || limit > 100000000 ){
        //   System.out.println("\nMinimum value must not be less than 2.");
        //   System.out.println("Maximum value must not be larger than 100000000.");
        //   System.out.print("Input upper limit for generating a list of prime numbers: ");
        //   limit = inp.nextInt();
        // }
        int limit = 0;
        for (int l = 400; l < 425; l++ ){
            limit = l;

            // Is index value NOT prime? Default is 'false': 'false' == PRIME number
            boolean sieve[] = new boolean[limit + 1];
            // reduce the limit to square root of limit
            limit = (int) Math.pow(limit, .5) + 1;
            System.out.println(l + ": " + limit + " ~ " + sieve.length);

            // 0 & 1 are not prime numbers; set to 'true'
            sieve[0] = true;
            sieve[1] = true;

            // conTINue = true means prime number found; continue the while loop
            boolean conTINue = true;

            // allows the 'primes' array to expand indefinitely
            // List<Integer> primes = new ArrayList<Integer>();

            // Start at 2 for both primes & index
            int index = 2;
            int count = 0;
            // primes.add(2);

            while (index < limit && conTINue) {

                // reset 'conTINue' default as 'false' to break loop
                // unless a new prime number is found
                conTINue = false;
                // shortens runtime by only updating multiples of successive primes
                // set multiples of current 'index' to 'true',
                // which means that 'index' is not a prime number
                for (int i = index * 2; i < sieve.length; i += index) {
                    if (!sieve[i])
                        sieve[i] = true;
                }

                count = 0;
                System.out.print(index+":\t");
                for (int j = 0; j < sieve.length; j++){
                    if (!sieve[j]){
                        count++;
                        System.out.print((j == 2) ? j : (", " + j));
                    }
                }
                System.out.println("\t--- PRIMES? " + count);

                // search for next prime number, that is where next prime[i] is false
                // search begins at 'index + 1'
                for (int i = index + 1; i <= (limit); i++) {
                    // if new prime number found, update index
                    // & update 'conTINue' set to 'true'
                    // & add new prime number to 'primes'
                    if (!sieve[i]) {
                        index = i;
                        conTINue = true;
                        break;
                    }
                }
                // TEST print for correct working of 'sieve'
                // System.out.println(index + "\t" + limit + "\t" + Arrays.toString(sieve));
            }
        }
        // FileWriter fw = new FileWriter("sieve.txt");
        // // SLOWEST part of program, screen output
        // fw.write("Number of primes: " + count + "\n");

        // for (int j = 2; j < sieve.length; j++){
        //   if (!sieve[j])
        //     fw.write((j == 2) ? (j + "") : (", " + j));
        // }

        // fw.write("\nNumber of primes: " + count + "\n");
        // fw.close();
        // // System.out.println(primes.toString() + "\nNumber of primes: " + count);
        // inp.close();

        // System.out.println(count + " prime numbers found. Prime numbers stored in 'sieve.txt'.");
    }
}
