import React from 'react'
import { MDBCard, MDBCardBody, MDBCardTitle, MDBCardText, MDBRow, MDBCol } from 'mdbreact'
import RegionList from './RegionList'

export default function Regions({signupDetails}) {
  const [checked, setChecked] = React.useState([1])

  return (
    <div>
      <MDBRow className='align-middle'>
        <MDBCol md='4'>
        </MDBCol>
        <MDBCol md='4'>
          <MDBCard>
            <MDBCardBody>
              <MDBCardTitle>Regions</MDBCardTitle>
              <MDBCardText className="scrollable">

                <RegionList checked={checked} setChecked={setChecked} />

              </MDBCardText>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
        <MDBCol md='4'>
        </MDBCol>
      </MDBRow>
      <br/>
      <br/>
    </div>
  )
}
