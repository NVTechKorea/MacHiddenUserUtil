clear
echo "HideYourAccount-1.7 툴을 시작하는중..."
sleep 1
echo Superuser 권한 요청:
sudo echo 현 프로세스에 루트권한이 부여되었습니다.
echo 루트 권한 활성화 완료.
echo "숨길 계정 ID:"
read loginid
echo 1/4: 사용자 체크중.
if [ ! -f /Volumes/Macintosh\ HD/Users/$loginid ]; then
	echo "ERROR:process:267"
	echo "Process cannot be continued."
	echo "Please use MakeHiddenUser.sh tool to solve this problem."
	exit
fi
if [ -f /Volumes/Macintosh\ HD/var/$loginid ]; then
	echo "ERROR:process:266"
	echo "Process cannot be continued."
	exit
fi
echo PASS
echo 2/4: 컨텐츠 옮기는중...
sudo mv -r /Users/$loginid /var/$loginid
echo 3/4: NFSHomeDirectory 지정중...
sudo dscl . create /Users/$loginid NFSHomeDirectory /var/$loginid
echo 4/4: 숨기는중...
sudo dscl . create /Users/$loginid IsHidden 1
echo 완료.
exit
