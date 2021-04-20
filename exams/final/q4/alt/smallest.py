"""
alt. smallest algo. uses too much space.
"""
def partition(arr, l, r, x):
    for i in range(l, r):
        if arr[i] == x:
            arr[r], arr[i] = arr[i], arr[r]
            break
    x = arr[r]
    i = l
    for j in range(l, r):
        if arr[j] <= x:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
    arr[i], arr[r] = arr[r], arr[i]
    return i

def findMedian(arr, l, n):
    lis = []
    for i in range(l, l+n):
        lis.append(arr[i])
    lis.sort()
    return lis[n//2]

def kthSmallest(arr, l, r, k):
    if k > 0 and k <= r-l+1:
        n = r-l+1
        median = []
        i = 0
        while i < n // 5:
            median.append(findMedian(arr, l+i*5, 5))
            i += 1
        if i*5 < n:
            median.append(findMedian(arr, l+i*5, n%5))
            i += 1
        if i == 1:
            medOfMed = median[i-1]
        else:
            medOfMed = kthSmallest(median, 0, i-1, i//2)
        pos = partition(arr, l, r, medOfMed)
        if pos-l == k-1:
            return arr[pos]
        if pos-l > k-1:
            return kthSmallest(arr, l, pos-1, k)
        return kthSmallest(arr, pos+1, r, k-pos+l-1)

arr = [12, 3, 5, 7, 4, 19, 26] 
n = len(arr) 
k = 3
print(kthSmallest(arr, 0, n - 1, k))