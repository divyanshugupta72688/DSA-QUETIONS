 class MS {
    void MergeSort(int[]arr,int si,int ei){
        if (si>=ei) {
            return;
        }
        int mid = si+(ei-si)/2;
        MergeSort(arr, si, mid);
        MergeSort(arr, mid+1, ei);
        Merge(arr,si,ei,mid);
    }
    void Merge(int[]arr,int si,int ei,int mid){
        int[] temp = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        while (i<=mid && j<=ei) {
            if (arr[i]<arr[j]) {
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i<=mid) {
            temp[k++] = arr[i++];
        }while (j<=ei) {
            temp[k++] = arr[j++];
        }
        for(int x  = 0,y=si;x<temp.length;x++,y++){
            arr[y] = temp[x];
        }
    }
}
