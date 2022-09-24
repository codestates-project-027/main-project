import { useState } from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import styled from 'styled-components';
import { TAG_CODE_REGEX } from '../../constants/regex';
import { BigBtn } from '../../components/Button/Btns';
//Formik
import { ErrorMessage, Field, Form, Formik } from 'formik';

export const ReadCategoryForm = ({ data }) => {
  return (
    <>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 400 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              {/* map */}
              <TableCell align="center">Code</TableCell>
              <TableCell align="center">Title</TableCell>
              <TableCell align="center">Status</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {data.map((row, idx) => (
              <TableRow
                key={idx}
                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
              >
                <TableCell align="center">{row.categoryCode}</TableCell>
                <TableCell align="center">{row.categoryTitle}</TableCell>
                <TableCell align="center">{row.categoryStatus}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};

export const InputCategoryForm = ({ idx, type }) => {
  return (
    <>
      <Formik
        initialValues={{ code: '', title: '', status: '' }}
        validate={(values) => {
          const errors = {};
          if (!values.code) {
            errors.code = 'ex) 000001';
          }
          if (!values.title) {
            errors.title = 'ex) 헬스';
          }
          if (!values.status) {
            errors.status = 'ex) ACTIVE / INACTIVE';
          }
          return errors;
        }}
        onSubmit={(values) => {
          console.log(values);
        }}
      >
        <Form>
          <FormWrapper>
            <div className="input--wrapper">
              <Field
                type="number"
                name="code"
                placeholder="Category Code"
                required
              />
              <ErrorMessage name="code" component="div" />
            </div>
            <div className="input--wrapper">
              <Field
                type="text"
                name="title"
                placeholder="Category Title"
                required
              />
              <ErrorMessage name="title" component="div" />
            </div>
            <div className="input--wrapper">
              <Field
                type="text"
                name="status"
                placeholder="Category Status"
                required
              />
              <ErrorMessage name="status" component="div" />
            </div>

            <BigBtn marginTop="20px">카테고리 {type}</BigBtn>
          </FormWrapper>
        </Form>
      </Formik>
    </>
  );
};

const FormWrapper = styled.div`
  display: flex;
  background: aliceblue;
  justify-content: center;
  flex-direction: column;
  margin-top: 30px;
  width: 500px;
  height: 250px;
  .input--wrapper {
    display: flex;
    margin-bottom: 10px;
  }
  input,
  select {
    width: 200px;
    height: 40px;
    border: none;
    box-shadow: 3px 3px 3px lightgray;
  }
  div {
    margin-left: 20px;
    align-items: center;
  }
  select {
    margin-left: 20px;
  }
  ${BigBtn} {
    margin-left: 50px;
  }
`;
