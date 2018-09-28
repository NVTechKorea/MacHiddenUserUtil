clear
echo "MHU-1.7 툴을 시작하는중..."
sleep 1
echo "Superuser 권한 요청:"
sudo echo 현 프로세스에 루트권한이 부여되었습니다.
echo "루트 권한 활성화 완료."
echo 1/1: 사용자 체크중.
if [ -f /Volumes/Macintosh\ HD/Users/hidden ]; then
	echo "ERROR:process:265"
	echo "프로세스를 계속 진행할 수 없음."
	echo "HideUser.sh 를 실행하여 문제 해결 가능."
	exit
fi
if [ -f /Volumes/Macintosh\ HD/var/hidden ]; then
	echo "ERROR:process:266"
	echo "프로세스를 계속 진행할 수 없음."
	exit
fi
echo "기존 히든 사용자가 존재하지 않음. 프로세스를 계속 진행."
echo "히든 계정 이름 생성:"
read username
echo "히든 ID 생성:"
read loginid
echo "히든 패스워드 생성:"
read password
echo "1/12: 기본 사용자 생성중..."
sudo dscl . -create /Users/$loginid
echo "2/12: 사용자 셸 지정중..."
sudo dscl . -create /Users/$loginid UserShell /bin/bash
echo "3/12: 이름 생성중 (이름: " $username ")"
sudo dscl . -create /Users/$loginid RealName $username
echo "4/12: UniqueID 생성중..."
sudo dscl . -create /Users/$loginid UniqueID 1001
echo "5/12: PrimaryGroupID 생성중..."
sudo dscl . -create /Users/$loginid PrimaryGroupID 1000
echo "6/12: NFSHomeDirectory 초기 설정중..."
sudo dscl . -create /Users/$loginid NFSHomeDirectory /var/$loginid
echo "7/12: Password 생성중... (패스워드: " $password ")"
sudo dscl . -passwd /Users/$loginid $password
echo "8/12: Administrator 권한 부여중..."
sudo dscl . -append /Groups/admin GroupMembership $loginid
echo "9/12: 숨김작업 시작"
echo "10/12: NFSHomeDirectory 지정중..."
sudo dscl . create /Users/$loginid NFSHomeDirectory /var/$loginid
echo "11/12: 컨텐츠 이동중..."
echo "12/12: 숨기는중..."
sudo dscl . create /Users/$loginid IsHidden 1
echo "완료."
echo " "
echo "로그인을 하려면 Login Window 에서 Other 를 누르고 다음과 같이 필드를 채우세요"
echo "Username: " $loginid
echo "Password: " $password
exit
