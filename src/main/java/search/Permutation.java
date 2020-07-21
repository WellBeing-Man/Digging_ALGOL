package search;


public class Permutation {

    void permutation(char[] letters, int n, int r) {

        if (n == r) {
            return;
        }

        for (int i = n; i < letters.length; i++) {

            swap(letters, n, i);

            permutation(letters, n + 1, r);

            swap(letters,n,i);
        }

    }

    private void swap(char[] letters, int n, int i) {
        char temp = letters[n];
        letters[n] = letters[i];
        letters[i] = temp;
    }
}
