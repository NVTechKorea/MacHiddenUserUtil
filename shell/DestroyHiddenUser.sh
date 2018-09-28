clear
echo "DESTROY-1.7 툴을 시작하는중..."
sleep 1
echo Superuser 권한 요청:
sudo echo 현 프로세스에 루트권한이 부여되었습니다.
echo 루트 권한 활성화 완료.
echo "히든 계정 로그인 ID:"
read loginid
echo "입력된 정보로 계정 제거를 시도합니다."
echo 백업 프로세스 시작:
echo 1/5: 백업 destination directory 를 생성중.
sudo mkdir /backup-vault
echo 2/5: $loginid 복사 시도중.
echo 3/5: 아카이브중.
cd /
sudo zip -r BackupVault.zip /var/$loginid
echo 4/5: 아카이브 파일을 Documents@root 에 저장중.
sudo cp BackupVault.zip /var/root/Documents
clear
echo 5/5: 일시 백업 파일 제거중.
sudo rm /BackupVault.zip
echo 백업 프로세스 종료.
clear
echo Left-over 청소 프로세스 시작:
sleep 1
clear
echo 1/1: Backup Cache Directory 청소중.
sudo rm -r /backup-vault
echo Left-over 청소 프로세스 종료.
echo 메인 프로세스 시작:
echo 1/5: 저장된 파일을 쿼리합니다.
echo 2/5: 파일 사이즈를 체크하는 중입니다.
sudo du -hs /var/$loginid
echo 3/5: 로그인 화면에서 활성화중입니다.
sudo dscl . create /Users/$loginid IsHidden 0
echo 4/5: 롤백중입니다.
sudo mv /var/$loginid /Users/$loginid
echo 5/5: 제거를 시작합니다.
sudo rm -r /Users/$loginid
sudo dscl . delete /Users/$loginid
echo 메인 프로세스 종료.
echo 히스토리 제거중...
history -c
echo 완료.
read -p "아무 키나 눌러 종료."
exit
