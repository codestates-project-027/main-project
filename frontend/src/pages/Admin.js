import { AdminGlobal } from "../styles/globalStyle/PageGlobalStyle";

const AdminPage = () => {
  return (
    <>
      <AdminGlobal>
          <div>현재 카테고리 목록: Code, Title, Status별 (table)</div>
          <div>카테고리 생성 form : Code, Title, Status 입력</div>
          <div>카테고리 수정 form: Title, Status 입력</div>
      </AdminGlobal>
    </>
  );
};

export default AdminPage;
