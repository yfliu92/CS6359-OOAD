**Init Project (useless in our project)**

- Ues `npm install` to install dependencies

**************
**Install dev dependencies**
- Run 'npm install package-name --save-dev'

**Install prod dependencies**
- Run 'npm install package-name --save'

***********
**Project Structure**

- WebContent
	- app
		- shared (shared component, EG, header, side bar, footer)
		- admin (jsp files related to admin functionality)
		- teacher (jsp files related to teacher functionality)
		- student (jsp files related to student functionality)	 	
		- styles
		- js (all javascript files used in different jsp)
	- public (public resources)
		- assets
		- css
		- js 
		
************
JavaScript Filename convention: [module].[filename].js `e.g., admin.addCourse.js ` 

*************
- First step, run `git checkout -b [local_branch]` to create and checkout a new local branch
- On your local branch, after changing file, run `git add -A` to add all files, run `git commit -m "message"`
- Use `git checkout master` to switch to local master branch
- Only run `git pull --rebase` when update
- Run `git merge [local_branch]` to merge your local branch on local master branch
- Resolve conflicts
- `git push`

*******
**Optional**
- Run `git checkout -b new_branch -t origin/master` to create a new local branch and track the remote master branch
- Dev on your local branch, before commit, run `git rebase -i` to squash all your commits to one, in vim, input `:%s/pick/s/gc`, type `n` (means pick) for first commit, type `y` (means squash) for the other commits