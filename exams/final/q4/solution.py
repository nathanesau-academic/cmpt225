def partition(arr, l, r):
    x, i = arr[r], l
    for j in range(l, r):
        if arr[j] <= x:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
    arr[i], arr[r] = arr[r], arr[i]
    return i
 
def quickselect(arr, k, l, r):
    if k > 0 and k <= r - l + 1:
        index = partition(arr, l, r)
        if index-l == k-1:
            return arr[index]
        elif index - l > k - 1: # left subarray
            return quickselect(arr, k, l, index - 1)
        else: # right subarray
            return quickselect(arr, k-index+l-1, index+1, r)

def quicksort(arr, l, r):
    if l < r:
        p = partition(arr, l, r)
        quicksort(arr, l, p-1)
        quicksort(arr, p+1, r)

arr = [3,1,5,2,8,12,4]
k = 4
kthSmallest = quickselect(arr, k, 0, len(arr)-1)
print(kthSmallest)
quicksort(arr, 0, k)
print(arr)