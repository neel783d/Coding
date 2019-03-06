
constraints = {}
distances = [[]]

def shortestPath(current, remain, sumConstraints):
    sumConstraints = sumConstraints.union(constraints[current])
    remain = remain
    if any((x in sumConstraints) for x in remain):
        return -1
    if len(remain) == 0:
        return 0

    results = []
    for node in remain:
        distTo = distances[current][node]
        distFrom = shortestPath(node, remain - set((node,)), sumConstraints)

    if distFrom == -1:
        continue

    results += [distFrom + distTo]
    if not results:
        return -1

    return min(results)


def run():
    for i in range(N):
        constraints[i] = set()

        for (x, y) in inps:
            constraints[y - 1].add(x - 1)

            # print(constraints)
            p = shortestPath(0, set(range(1, N)), set())
            print(p, out, p == out)
