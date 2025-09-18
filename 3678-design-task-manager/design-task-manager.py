class TaskManager:

    def __init__(self, tasks: List[List[int]]):
        self.taskMap={}
        self.heap=[]

        for userId,taskId,priority in tasks:
            self.taskMap[taskId]=(userId,priority)
            heapq.heappush(self.heap,(-priority, -taskId,userId,taskId))

    def add(self,userId:int ,taskId: int,priority:int)->None:
        self.taskMap[taskId]=(userId,priority)
        heapq.heappush(self.heap,(-priority,-taskId,userId,taskId))
    
    def edit(self,taskId:int,newPriority:int)->None:
        userId, _= self.taskMap[taskId]
        self.taskMap[taskId]=(userId,newPriority)
        heapq.heappush(self.heap,(-newPriority,-taskId,userId,taskId))

    def rmv(self,taskId:int)->None:
        if taskId in self.taskMap:
            del self.taskMap[taskId]



    def execTop(self)->int:
        while self.heap:
            priority , negTaskId,userId,taskId=heapq.heappop(self.heap)
            if taskId in self.taskMap:
                latestUserId, latestPriority=self.taskMap[taskId]
                if latestPriority == -priority and latestUserId == userId:
                    del self.taskMap[taskId]
                    return userId
        return -1
        

    # def add(self, userId: int, taskId: int, priority: int) -> None:
        

    # def edit(self, taskId: int, newPriority: int) -> None:
        

    # def rmv(self, taskId: int) -> None:
        

    # def execTop(self) -> int:
        


# Your TaskManager object will be instantiated and called as such:
# obj = TaskManager(tasks)
# obj.add(userId,taskId,priority)
# obj.edit(taskId,newPriority)
# obj.rmv(taskId)
# param_4 = obj.execTop()