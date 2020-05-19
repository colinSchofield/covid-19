import React from 'react'
import { MDBCard, MDBCardBody, MDBCardTitle, MDBCardText, MDBRow, MDBCol } from 'mdbreact'
import Image from 'react-bootstrap/Image'
import BannerImg from '../../assets/images/Coronavirus-Banner.png'

export default function Welcome({signupDetails}) {

    React.useEffect(() => {

      const person = {name: "Bob", age: 23}

      if (!signupDetails.current) {
        signupDetails.current = person
      }
      console.log("details", signupDetails)

    }, [])

  return (
    <div>
      <MDBRow className='align-middle'>
        <MDBCol md='4'>
        </MDBCol>
        <MDBCol md='4'>
          <MDBCard>
            <Image className="img-fluid" src={BannerImg} />
            <MDBCardBody>
              <MDBCardTitle>Welcome</MDBCardTitle>
              <MDBCardText>
                Some quick example text to build on the card title and make
                up the bulk of the card&apos;s content.
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