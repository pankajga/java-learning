## Git revert vs reset ?

* https://4sysops.com/archives/git-reset-vs-git-revert/#:~:text=Git%20revert%20is%20a%20command,made%20in%20the%20target%20commit.
git reset is like rewinding the project's history to a particular point. Technically, the command moves the HEAD and the branch pointer to a specific commit.


A branch pointer is a reference that points to the latest commit in a particular branch's history. A commit is a snapshot of the entire repository at a point in time.

HEAD is a pointer to the most recent commit in the current branch. It is your current position within the repository. If you make a new commit, HEAD moves to point to the new commit. This means that HEAD alGit revert is a command used to create a new commit that undoes the changes introduced by a specific commit. Unlike git reset, which modifies the project history, git revert creates a new commit that effectively cancels out the changes made in the target commit. ways points to the latest changes you have made to your code.


