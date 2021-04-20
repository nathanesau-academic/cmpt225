import heapq

def build_graph(board):
    graph = {}
    for i in range(len(board)):
        for j in range(len(board[i])):
            graph[(i,j)] = []
            if i-1 >= 0 and board[i][j] == 1:  # up
                graph[(i,j)].append((i-1, j))
            if i+1 < len(board) and board[i][j] == 1:  # down
                graph[(i,j)].append((i+1, j))
            if j-1 >= 0 and board[i][j] == 1:  # left
                graph[(i,j)].append((i, j-1))
            if j+1 < len(board[i]) and board[i][j] == 1:  # right
                graph[(i,j)].append((i, j+1))
    return graph

def shortest_path(prev, src, target):
    path = []
    u = target
    while u != src:
        path.insert(0, u)
        u = prev[u]
    path.insert(0, src)
    return path

def solve(graph, src, target):
    dist = dict((k, float('inf')) for k in graph.keys())
    prev = dict((k, None) for k in graph.keys())
    dist[src] = 0
    pq = [(0, src)]
    while pq:
        #distu, u = heapq.heappop(pq)
        distu, u = pq.pop(0)
        if u == target:
            return shortest_path(prev, src, u)
        for v in graph[u]:  # neighbors
            alt = distu + 1
            if alt < dist[v]:
                dist[v] = alt
                prev[v] = u
                #heapq.heappush(pq, (alt, v))
                pq.append((alt, v))

board = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,1,1],[1,1,1,0,0],[1,1,1,1,1],[0,0,1,0,1]]
graph = build_graph(board)
for k, v in graph.items():
    print(f"{k}: {v}")

path = solve(graph, (0,0), (5,4))
print(path)
