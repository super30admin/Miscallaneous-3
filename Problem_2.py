#
# @lc app=leetcode id=911 lang=python3
#
# [911] Online Election
#
# @lc code=start
'''
Time Complexity - O(log n).
Space Complexity - O(n)

Works on leetcode
'''
class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.leader = 0
        self.countMap = {}
        self.leaderMap = {}
        self.time = times
        for i in range(len(persons)):
            p = persons[i]
            t = times[i]
            #store the number of votes for each candidate
            self.countMap[p] = self.countMap.get(p,0)+1
            #check if the current candidate has received more votes than leader, in that case the candidate become leader
            if self.countMap[p] >= self.countMap.get(self.leader):
                self.leader = p
            #store the leader at that time
            self.leaderMap[t] = self.leader
    
    def q(self, t: int) -> int:
        #if the key exits for that time return the value in the map
        if t in self.leaderMap:
            return self.leaderMap.get(t)
        #else we run a binary search to get nearest time in the time array and get leader at the latest time available
        low, high = 0, len(self.time)-1
        while low<=high:
            mid = low + int((high-low)/2)
            if self.time[mid] > t:
                high = mid - 1
            else:
                low = mid + 1
        return self.leaderMap.get(self.time[high])
        


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
# @lc code=end

