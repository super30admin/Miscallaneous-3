# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TopVotedCandidate:
    # Time Complexity :O(N) where N is length of persons/times array
    # Space Complexity :O(N) where N is length of persons/times array
    def __init__(self, persons: List[int], times: List[int]):
        self.leaderMap = {}
        self.timeMap = {}
        self.times = times
        leader = persons[0]
        
        for v in range(len(persons)):
            if persons[v] not in self.leaderMap:
                self.leaderMap[persons[v]] = 0
            
            self.leaderMap[persons[v]] += 1
            
            if self.leaderMap[leader] <= self.leaderMap[persons[v]]:
                leader = persons[v]
            
            self.timeMap[times[v]] = leader

    # Time Complexity :O(1) in best-case otherwise O(log N) when timestamp is not in times array N is length of persons/times array
    # Space Complexity :O(1)
    def q(self, t: int) -> int:
        if t in self.timeMap:
            return self.timeMap[t]
        else:
            low = 0
            high = len(self.times) - 1

            while low <= high:
                mid = low + (high - low) // 2

                if self.times[mid] < t:
                    low = mid + 1
                else:
                    high = mid - 1

            return self.timeMap[self.times[high]]