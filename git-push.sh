#!/usr/bin/env sh

# 确保脚本抛出遇到的错误
set -e

# git配置
mkdir -p ~/.ssh/
echo "$GIT_SSH_RSA_PRIVATE_KEY" | tr -d '\r' >~/.ssh/id_rsa
chmod 600 ~/.ssh/id_rsa
rm -rf ~/.ssh/known_hosts
ssh-keyscan github.com >>~/.ssh/known_hosts
git config --global user.name 'imaliang'
git config --global user.email 'aliang.link@foxmail.com'
echo '🎉 🎉 🎉 git set done 🎉🎉🎉'

git pull

GIT_STATUS=$(git status -s)

echo '----------git status -s-----------'
echo $GIT_STATUS
echo '----------------------------------'

# 检测是否有文件变更
if [ -z "$GIT_STATUS" ]; then
  echo "没有检测到文件变更，无需推送。"
else
  echo "检测到有文件变更，执行提交和推送..."
  git add -A
  git commit -m '👽 自动更新'
  git push
  echo '🎉 🎉 🎉 OnePieceHtml push success 🎉 🎉 🎉'
fi

echo '🎉 🎉 🎉 OnePieceHtmlGenerator done 🎉 🎉 🎉'

# 测试用
#echo 按任意键继续
#read -n 1
#echo 继续
