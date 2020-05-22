import React from 'react'
import { MDBCard, MDBCardBody, MDBCardTitle, MDBCardText, MDBRow, MDBCol } from 'mdbreact'
import Image from 'react-bootstrap/Image'
import BannerImg from '../../assets/images/Coronavirus-Banner.jpg'

export default function Welcome() {
  return (
    <>
      <MDBRow className='align-middle'>
        <MDBCol md='4'>
        </MDBCol>
        <MDBCol md='4'>
          <MDBCard>
            <Image className="img-fluid" src={BannerImg} />
            <MDBCardBody>
              <MDBCardTitle>Welcome</MDBCardTitle>
              <MDBCardText>
              Please sign-up here, so you may receive notifications via email or SMS.
              <br/><br/>
              The information you are providing is <b>private</b> and will remain completely <b>confidential</b>. It shall not be used for advertising purposes.
              </MDBCardText>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
        <MDBCol md='4'>
        </MDBCol>
      </MDBRow>
      <br/>
      <br/>
    </>
  )
}