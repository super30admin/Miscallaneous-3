class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.countmap = defaultdict(int)
        self.leaders = defaultdict(int)
        self.leader = 0
        self.times = times
        # for i, (person, time) in enumerate(zip([persons, times])):
        # O(n)
        for i,person in enumerate(persons):
            self.countmap[person] += 1
            if self.countmap[person] >= self.countmap[self.leader]:
                self.leader = person
                self.leaders[self.times[i]] = person
            self.leaders[self.times[i]] = self.leader

    # O(logn )
    def q(self, t: int) -> int:
        low = 0
        high = len(self.times) - 1
        while low <= high:
            mid = low + (high -low)//2
            if self.times[mid] > t:
                high = mid - 1
            else:
                low = mid + 1
        return self.leaders[self.times[high]]



# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
