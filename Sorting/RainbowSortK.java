public class RainbowSortK {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColorsK(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }
    
    private void rainbowSort(int[] colors,
                            int left,
                            int right,
                            int colorFrom,
                            int colorTo){
        if (colorFrom == colorTo) {
            return;
        }
        
        if (left >= right) {
            return;
        }
        
        int colorMid = colorFrom + (colorTo - colorFrom) / 2;
        int l = left, r = right;
        
        while (l <= r) {
            if (colors[l] <= colorMid) {
                l++;
            } else if (colors[r] > colorMid) {
                r--;
            } else {
                swap(colors, l++, r--);
            }
        }
        
        rainbowSort(colors, left, r, colorFrom, colorMid);
        rainbowSort(colors, l, right, colorMid + 1, colorTo);
    }
    
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        
    }
}
